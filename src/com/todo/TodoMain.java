package com.todo;
import java.util.Scanner;

import com.todo.dao.TodoList;
import com.todo.menu.Menu;
import com.todo.service.TodoUtil;

public class TodoMain {
	
	public static void start() {
	
		Scanner sc = new Scanner(System.in);
		TodoList l = new TodoList();
		l.importData("todolist.txt");
		boolean isList = false;
		boolean quit = false;
		Menu.displaymenu();
//		TodoUtil.loadList(l,"todolist.txt");
		do {
			Menu.prompt();
			isList = false;
			String choice = sc.next();
			switch (choice) {

			case "add":
				TodoUtil.createItem(l);
				break;
			
			case "del":
				TodoUtil.deleteItem(l);
				break;
				
			case "edit":
				TodoUtil.updateItem(l);
				break;
				
			case "ls":
				TodoUtil.listAll(l);
				break;

			case "ls_name":
				System.out.println("제목순 정렬");
				TodoUtil.listAll(l, "title", 1);
				break;

			case "ls_name_desc":
				System.out.println("제목순 정렬");
				TodoUtil.listAll(l, "title", 0);
				break;
				
			case "ls_date":
				System.out.println("날짜순 정렬");
				TodoUtil.listAll(l, "due_date", 1);
				break;

			case "ls_date_desc":
				System.out.println("날짜순 정렬");
				TodoUtil.listAll(l, "due_date", 0);
				break;
				
			case "ls_cate":
				TodoUtil.listCateAll(l);
				break;
				
			case "find":
				String word = sc.nextLine().trim();
				TodoUtil.findList(l, word);
				break;
				
			case "find_cate":
				String cate = sc.next();
				TodoUtil.findCateList(l, cate);
				break;
				
			case "help":
				Menu.displaymenu();
				break;

			case "exit":
				quit = true;
				break;

			default:
				System.out.println("정해진 명령어만 입력해주세요 (도움말: help)");
				break;
			}
			if(isList) TodoUtil.listAll(l);
		} while (!quit);
		
		TodoUtil.saveList(l,"todolist.txt");
	}
}
