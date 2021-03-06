/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3.Reto3.web;

import java.util.Collections;
import java.util.Map;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pampi
 */
@RestController
public class UsuarioWeb {
     @GetMapping("/usuario")
    public Map<String, Object> obtenerUsuarioLogeado(@AuthenticationPrincipal OAuth2User usuario){
        //return usuario.getAttributes();
        return Collections.singletonMap("name", usuario.getAttribute("name"));
    }
}
