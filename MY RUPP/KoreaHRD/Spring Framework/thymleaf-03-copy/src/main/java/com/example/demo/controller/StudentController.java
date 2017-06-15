package com.example.demo.controller;

//herekdsafkasjdlfjasd;lfjasdf;adsfadsfkj;l

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


import com.example.demo.model.StudentModel;
import com.example.demo.service.StudentService;

@Controller
public class StudentController extends WebMvcConfigurerAdapter {
	
	private StudentService studentService;
	
	
	@Autowired
	public StudentController(StudentService studentService) {
	
		this.studentService = studentService;
	}
	
	 @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController("/addStudent").setViewName("addStudent");
	    }
	
	@GetMapping(value = "/student")
	public String homepage(ModelMap model){
		List<StudentModel> studentList = studentService.findAll();
		
		model.addAttribute("student",studentList);
		return "/student";
	}

	@GetMapping(value = "/student/view")
	public String viewpage(ModelMap model, @RequestParam("id") Integer id){
		StudentModel student = studentService.findOne(id);
		
		model.addAttribute("student", student);
		
		return "viewPage";
	}
	
	@GetMapping(value = "/student/remove/{id}")
	public String remove(ModelMap model, @PathVariable("id") Integer id){
		
		studentService.remover(id);
		
		return "redirect:/student";
	}

	
	
//	++++++++++++++++++++++ method for Validation but still have error. because it can not
//						   show error message on form but it can show error message on console +++++++++++++++++++++++++
	
	
	@GetMapping(value = "/student/add")
	public String saveStudent(ModelMap modelMap){
		
		modelMap.addAttribute("student",new StudentModel());
		return "addStudent";
	}
	

	@PostMapping(value = "/student/save")
	public String save(@Valid StudentModel student, BindingResult result){
		if(result.hasErrors()){
			
			System.out.println(result.getFieldError().getDefaultMessage());
			return "redirect:/student/add";
			
		}
		if(studentService.save(student))
			System.out.println("success");;
		
		return "redirect:/student";
	}
	
	@GetMapping(value = "/student/edit/{id}")
	public String editStudent(@PathVariable("id") Integer id, ModelMap modelMap){
		
		modelMap.addAttribute("student", studentService.findOne(id));
		return "updateStudent";
	}
	
	@PostMapping(value = "/student/update")
	public String saveStudent(StudentModel student, BindingResult result){
		if(result.hasErrors()){
			return "redirect:/student/edit/"+student.getId();
		}
		if(studentService.update(student))
			System.out.println("success!");
		return "redirect:/student";
	}
	
	
	
//	+++++++++++++++++++++ method for upload for upload Student.html +++++++++++++++++++++++++++
	
	
	private static String upload = "fileupload/";
	
	@GetMapping(value = "/upload/file")
	public String uploadPage(){
		return "uploadFile";
	}
	
	@PostMapping(value = "/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file){
		try{
			byte[] bytes = file.getBytes();
			Path path = Paths.get(upload + file.getOriginalFilename());
			Files.write(path, bytes);
		}catch (IOException err){
			err.printStackTrace();
		}
		System.out.println("success");
		return "redirect:/student";
	}

}
