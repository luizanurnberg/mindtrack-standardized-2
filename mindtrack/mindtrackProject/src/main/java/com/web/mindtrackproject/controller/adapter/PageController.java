package com.web.mindtrackproject.controller.adapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/api")
public class PageController {
    private final NotFoundAdapter notFoundAdapter;

    @Autowired
    public PageController(NotFoundAdapter notFoundAdapter) {
        this.notFoundAdapter = notFoundAdapter;
    }

    @GetMapping("/404")
    @ResponseStatus(HttpStatus.OK)
    public void notFoundRoute() {
        notFoundAdapter.handleError();
        System.out.println("error 404");
    }
}
