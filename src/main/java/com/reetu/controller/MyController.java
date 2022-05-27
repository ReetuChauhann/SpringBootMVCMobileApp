package com.reetu.controller;

import java.io.InputStream;
import java.util.List;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reetu.beans.Mobile;
import com.reetu.dao.Mobilerepo;

@Controller
public class MyController {
	
	                         @Autowired
	                         Mobilerepo mr;
	                         
	                         @RequestMapping("/")
	                         public String home() {
	                        	 return "index";
	                         }
	                       @RequestMapping("/addMobile")
	                       public String addmobile(@ModelAttribute Mobile m, Model model, Part image1) {
	                    	   
	                    	   InputStream in1 = null;
	                    	   if(image1!=null) {
	                    		   try {
									          in1 = image1.getInputStream(); //in1 will send the data
								} catch (Exception e) {
									in1 = null;
								}
	                    	 }
	                    String add = mr.addmoblie(m, in1);
	                    model.addAttribute("add", add);
	                    return "index";
	                 }
	                       
	                    @RequestMapping("/deletemobile")
	                    public String deletemobile(String mname, Model model) {
	                    	String msg2 = mr.deletemobile(mname);
	                    	model.addAttribute("delete", msg2);
	                    	return "index";
	                    	
	                    }
	                   @RequestMapping("/UpdateMobile")
	                   public String returnpage() {
	                	   return "UpdateMobile";
	                   }
	                   
	                  @ModelAttribute()
	                  public void commonValues(Model model) {
	                	  List<String> s = mr.getallmobilename();
	                	  model.addAttribute("list",s);
	                	  }
	                  
	                  @RequestMapping("/Updatehere")
	                  public String updatemobile(@ModelAttribute Mobile m, String mname, Model model){
	                	  String result = mr.updatemobile(mname, m);
	                	  model.addAttribute("result", result);
	                	  return "UpdateMobile";
	                  }
	                 @RequestMapping("/viewallmobile")
	                 public String viewall(){
	                	 return "viewallmobile";
	                 }
	                 @RequestMapping("/viewall")
	                 public String getall(Model model){
	                	 List<Mobile> keys = mr.getallmobile(); 
	                	 model.addAttribute("keys", keys);
	                	 return "viewallmobile";
	                 }
	                 
	                 //getimage
	                 @RequestMapping("/getimage1")
	                 public void getimage(String mname, HttpServletResponse response) { //void type httpresponse resposible to travel
	                	 
	                	 try {
							  byte [] b =mr.getimage(mname);
							  response.getOutputStream().write(b);
						} catch (Exception e) {
							e.printStackTrace();
						}
	                 }

//	                 @RequestMapping("/getimage2")
//	                 public void getimage2(String mname, HttpServletResponse response) {
//	                	 
//	                	 try {
//							  byte [] b2 = mr.getimage(mname);
//							  response.getOutputStream().write(b2);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//	                 }

}
