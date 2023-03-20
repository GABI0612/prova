package uea.prova_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uea.prova_api.models.Refeicao;
import uea.prova_api.repositories.RefeicaoRepository;

@Service
public class RefeicaoService {
	
	@Autowired
	private RefeicaoRepository refeicaoRepository;
	
	public Refeicao criar(Refeicao refeicao) {
		return refeicaoRepository.save(refeicao);
	}
	
	public List<Refeicao> listar(){
		return refeicaoRepository.findAll();
	}
	
	public void excluir(Long codigo) {
		refeicaoRepository.deleteById(codigo);
	}
	
	

}
