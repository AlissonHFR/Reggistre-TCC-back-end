package br.fai.reggistre.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fai.reggistre.api.service.HistoricService;
import br.fai.reggistre.model.entities.Historico;


@RestController
@RequestMapping("/api/v1/historic")
@CrossOrigin(origins = "*")
public class HistoricRestController {
	
	@Autowired
	private HistoricService historicService;
	
	@GetMapping("/read-all")
	public ResponseEntity< List<Historico>> readAll(){
		
		List<Historico> historicoList = historicService.readAll();
		
		if(historicoList == null || historicoList.size() == 0) {
			return ResponseEntity.ok(null);
		}else {
			return ResponseEntity.ok(historicoList);
					
		}
		
	}
	
	@GetMapping("/read-by-id/{id}")
	public ResponseEntity<Historico> readById(@PathVariable("id")Long id){
		
		Historico historico = historicService.readById(id);
		
		if(historico == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(historico);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Boolean> update(@RequestBody Historico entity){
		
		boolean response = historicService.update(entity);
		
		return ResponseEntity.ok(response);
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<Long> create(@RequestBody Historico entity){
		
		Long id = historicService.create(entity);
		
		return ResponseEntity.ok(id);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id")Long id){
		
		boolean response = historicService.deleteById(id);
		
		return ResponseEntity.ok(response);
		
	}

}
