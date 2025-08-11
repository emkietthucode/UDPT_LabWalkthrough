package com.ctk.quanlynhanvien;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class QuanlynhanvienApplication implements QuanLyNhanVien {

	public static void main(String[] args) {
  SpringApplication.run(QuanlynhanvienApplication.class, args);
 } 
 
 @Override 
 public String LayThongTinNhanVien() { 
  // TODO Auto-generated method stub 
  String str = "This is employee information"; 
  return str; 
 } 
 
 @Override 
 public void ThemNhanVien() { 
  // TODO Open connection 
  // Insert database 
  // Close connection 
  // Done 
     
 } 
 
} 