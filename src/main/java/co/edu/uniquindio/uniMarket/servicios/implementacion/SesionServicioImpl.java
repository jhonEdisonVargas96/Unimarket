package co.edu.uniquindio.uniMarket.servicios.implementacion;

import co.edu.uniquindio.uniMarket.DTO.SesionDTO;
import co.edu.uniquindio.uniMarket.DTO.TokenDTO;
import co.edu.uniquindio.uniMarket.security.modelo.UserDetailsImpl;
import co.edu.uniquindio.uniMarket.security.servicios.JwtService;
import co.edu.uniquindio.uniMarket.servicios.interfaces.SesionServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SesionServicioImpl implements SesionServicio {

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @Override
    public TokenDTO login(SesionDTO sesionDTO) {
        Authentication authentication = authenticationManager.authenticate(new
                UsernamePasswordAuthenticationToken(sesionDTO.getEmail(), sesionDTO.getPassword()));
        UserDetails userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String jwtToken = jwtService.generateToken(userDetails);

        return new TokenDTO(jwtToken);
    }

    @Override
    public void logout(int codigoUsuario) {

    }
}