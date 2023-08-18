package hn.unah.lenguajes.chinese.services.impl;

import org.springframework.stereotype.Service;

import hn.unah.lenguajes.chinese.models.Cliente;
import hn.unah.lenguajes.chinese.models.Personas;
import hn.unah.lenguajes.chinese.repositories.ClientesRepository;
import hn.unah.lenguajes.chinese.repositories.PersonasRepository;
import hn.unah.lenguajes.chinese.services.ClientesService;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesServiceImpl implements ClientesService {

    private final PersonasRepository personaRepository;
    private final ClientesRepository clientesRepository;

    public ClientesServiceImpl(PersonasRepository personaRepository, ClientesRepository clientesRepository) {
        this.personaRepository = personaRepository;
        this.clientesRepository = clientesRepository;
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        Personas personaGuardada = personaRepository.save(cliente);
        cliente.setId(personaGuardada.getId());
        return clientesRepository.save(cliente);
    }

    @Override
    public Cliente buscarPorId(int id) {
        return clientesRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente borrarPorId(int id) {
        Optional<Cliente> optionalCliente = clientesRepository.findById(id);
        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            clientesRepository.delete(cliente);
            return cliente;
        }
        return null;
    }

    @Override
    public List<Cliente> regresarTodo() {
        return (List<Cliente>) clientesRepository.findAll();
    }
}
