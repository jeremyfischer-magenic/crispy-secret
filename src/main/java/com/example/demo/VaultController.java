package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.vault.core.VaultOperations;
import org.springframework.vault.support.VaultResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class VaultController {

    @Autowired
    private VaultOperations operations;

    @RequestMapping("/v1/**")
    public @ResponseBody
    Map<String, Object>  getVault(HttpServletRequest request) {
        String uri = request.getRequestURI();
        String requestString = uri.replace("/v1", "");
        VaultResponse result = operations.read(requestString);
        return result.getData();
    }
}
