package com.coursematch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coursematch.entity.Curso;
import com.coursematch.repository.CursoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CursoService {

	private final CursoRepository cursoRepository;

	public Curso registrar(Curso curso) {
		return cursoRepository.save(curso);
	}

	public List<Curso> listar() {
		return cursoRepository.findAll();
	}

	public Optional<Curso> buscarPorId(Long id) {
		return cursoRepository.findById(id);
	}

	public Curso actualizar(Long id, Curso curso) {

		Optional<Curso> cursoOptional = cursoRepository.findById(id);

		if (cursoOptional.isPresent()) {

			Curso cursoEncontrado = cursoOptional.get();

			cursoEncontrado.setCodigo(curso.getCodigo());
			cursoEncontrado.setNombre(curso.getNombre());
			cursoEncontrado.setCreditos(curso.getCreditos());
			cursoEncontrado.setHoras(curso.getHoras());
			cursoEncontrado.setInstitucion(curso.getInstitucion());

			Curso cursoActualizado = cursoRepository.save(cursoEncontrado);

			return cursoActualizado;

		}

		return null;

	}

	public void eliminarPorId(Long id) {

		if (cursoRepository.existsById(id)) {
			cursoRepository.deleteById(id);
		}

	}

}
