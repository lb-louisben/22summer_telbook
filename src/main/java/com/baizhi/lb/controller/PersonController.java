package com.baizhi.lb.controller;

import com.baizhi.lb.entity.Person;
import com.baizhi.lb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("person")
public class PersonController {
    // DI
    @Autowired
    private PersonService personService;
/*
    @RequestMapping("queryAll")
    public String queryAll(Model model) {
        List<Person> list = personService.listAllPersons();
        model.addAttribute("list", list);
        return "forward:/person/index.jsp";
    }*/

    @RequestMapping("queryByPage")
    public String queryByPage(Integer currentPage, Model model) {
        Integer pageSize = 3;
        List<Person> list = personService.queryByPage(currentPage, 3);
        Integer totalPage = personService.getTotalPage(pageSize);

        // 往 request 存数据， 当前页currentPage, 当前页的数据list, 总页数
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("list", list);

        System.out.println(list);
        // 请求转发
        return "forward:/person/index.jsp";
    }

    @RequestMapping("register")
    public String register(Person p) {
        personService.register(p);
        // 添加成功，跳转到展示页面  controller => controller 重定向
        return "redirect:/person/queryByPage?currentPage=1";
    }

    @RequestMapping("delete")
    public String delete(Integer id) {
        personService.deleteOnePerson(id);
        // 添加成功，跳转到展示页面  controller => controller 重定向
        return "redirect:/person/queryByPage?currentPage=1";
    }

    @RequestMapping("modifyQuery")
    public String modifyQuery(Integer id, Model model) {
        Person person = personService.selectById(id);
        // 在 request 中存 person
        System.out.println(person);
        model.addAttribute("person", person);
        // 跳转到edit.jsp
        return "forward:/person/edit.jsp";
    }

    @RequestMapping("modifySave")
    public String modifySave(Person p, Model model) {
        personService.update(p);
        return "redirect:/person/queryByPage?currentPage=1";
    }

}
