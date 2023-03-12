package br.ifsp.edu.pep.main;

import br.ifsp.edu.pep.dao.UsuarioDAO;

import br.ifsp.edu.pep.model.Usuario;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {
        Usuario usuario = new Usuario("Felipe", new Date(), "felipe@gmail.com", "1", "Rua Luiz Paulino 323", "Presidente Epitácio", "SP", "(18)981712939", "Gerente");
        UsuarioDAO controle = new UsuarioDAO();
        controle.insert(usuario);
    }
}
