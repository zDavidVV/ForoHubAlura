package com.alura.aluraforohub.controller;

import com.alura.aluraforohub.infra.security.DatosJWTToken;
import com.alura.aluraforohub.infra.security.TokenService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import com.alura.aluraforohub.domain.usuarios.DatosAutenticacionUsuario;
import com.alura.aluraforohub.domain.usuarios.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Tag(name = "Autenticacion", description = "obtiene el token para el usuario asignado que da acceso al resto de endpoint")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.login(),
                datosAutenticacionUsuario.clave());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }

}