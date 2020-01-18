package com.board.example.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.example.service.BoardService;


@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Inject
	BoardService boardService;
    
    @RequestMapping("detectControl.do")
    public String pictureDetectControl() {
    	return boardService.pictureDetect(); 
    }

}