package uea.prova_api.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import uea.prova_api.models.Consumidor;
import uea.prova_api.services.ConsumidorService;

@RestController
@RequestMapping("/consumidores")
public class ConsumidorResource {
	
	@Autowired
	private ConsumidorService consumidorService;
	
	@PostMapping
	public ResponseEntity<Consumidor> criar(@Validated @RequestBody Consumidor consumidor) {
		Consumidor consumidorSalva = consumidorService.criar(consumidor);
		
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequest().path("/{codigo}").
				buildAndExpand(consumidorSalva.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).body(consumidorSalva);
	}
	
	@GetMapping
	public ResponseEntity<List<Consumidor>> listar() {
		List<Consumidor> consumidors = consumidorService.listar();
		return ResponseEntity.ok().body(consumidors);
	}
	
	@GetMapping(value = "/{codigo}")
	public ResponseEntity<Consumidor> buscarPorCodigo(@PathVariable 
			Long codigo){
		Consumidor consumidor = consumidorService.buscarPorCodigo(codigo);
		return ResponseEntity.ok().body(consumidor);
	}
	
	@DeleteMapping(value="/{codigo}")
	public ResponseEntity<Void> excluir(@PathVariable Long codigo){
		consumidorService.excluir(codigo);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{codigo}")
	public ResponseEntity<Consumidor> atualizar(@PathVariable Long codigo,
			@Validated @RequestBody Consumidor consumidor){
		Consumidor consumidorSalva = consumidorService.atualizar(codigo,
				consumidor);
		return ResponseEntity.ok().body(consumidorSalva);
		
	}
	
	
	
}
