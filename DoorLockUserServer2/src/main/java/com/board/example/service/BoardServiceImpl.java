package com.board.example.service;

import java.io.File;

import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	@Override
	public String pictureDetect() {
		File file = new File("C:/Users/GZ/share/detect123.jpg");
		while (true) {
			boolean isExists = file.exists();
			System.out.println("°¡µ¿Áß..");
			try {
				if (!isExists) {
					continue;
				}
				if (isExists) {
					return "redirect:http://192.168.43.158/TakeApict.php";
				}
				file.delete();
			} catch (Exception e) {
				
			}
		}
	}
}