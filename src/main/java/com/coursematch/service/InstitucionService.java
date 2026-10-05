package com.coursematch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coursematch.entity.Institucion;
import com.coursematch.repository.InstitucionRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InstitucionService {
	
	private final InstitucionRepository institucionRepository;

	public Institucion registrar(Institucion institucion) {
		return institucionRepository.save(institucion);
	}
	
	public List<Institucion> listar() {
		return institucionRepository.findAll();
	}
	
	public Optional<Institucion> buscarPorId(Long id) {
		return institucionRepository.findById(id);
	}
	
	public Institucion actualizar(Long id, Institucion institucion) {

	    Optional<Institucion> institucionOptional = institucionRepository.findById(id);

	    if (institucionOptional.isPresent()) {

	        Institucion institucionEncontrada = institucionOptional.get();

	        institucionEncontrada.setNombre(institucion.getNombre());
	        institucionEncontrada.setTipo(institucion.getTipo());
	        
	        Institucion institucionActualizada = institucionRepository.save(institucionEncontrada);

	        return institucionActualizada;
	    }

	    return null;
	}
	
	public void eliminarPorId(Long id) {
		
		if (institucionRepository.existsById(id)) {
			institucionRepository.deleteById(id);
		}
		
	}
	
	
	
	
	
	
	
	

}
