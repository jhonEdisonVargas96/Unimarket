package co.edu.uniquindio.uniMarket.controladores;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class ModeradorControlador {
}