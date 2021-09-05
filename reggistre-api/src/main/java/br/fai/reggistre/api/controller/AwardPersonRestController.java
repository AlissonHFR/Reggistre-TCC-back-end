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

import br.fai.reggistre.api.service.AwardPersonService;
import br.fai.reggistre.model.entities.PremioPessoa;


@RestController
@RequestMapping("/api/v1/award-person")
@CrossOrigin(origins = "*")
public class AwardPersonRestController {
	
	@Autowired
	private AwardPersonService awardPersonService;
	
	@GetMapping("/read-all")
	public ResponseEntity< List<PremioPessoa>> readAll(){
		
		List<PremioPessoa> premioPessoaList = awardPersonService.readAll();
		
		if(premioPessoaList == null || premioPessoaList.size() == 0) {
			return ResponseEntity.ok(null);
		}else {
			return ResponseEntity.ok(premioPessoaList);
					
		}
		
	}
	
	@GetMapping("/read-by-id/{id}")
	public ResponseEntity<PremioPessoa> readById(@PathVariable("id")Long id){
		
		PremioPessoa premioPessoa = awardPersonService.readById(id);
		
		if(premioPessoa == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(premioPessoa);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Boolean> update(@RequestBody PremioPessoa entity){
		
		boolean response = awardPersonService.update(entity);
		
		return ResponseEntity.ok(response);
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<Long> create(@RequestBody PremioPessoa entity){
		
		Long id = awardPersonService.create(entity);
		
		return ResponseEntity.ok(id);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id")Long id){
		
		boolean response = awardPersonService.deleteById(id);
		
		return ResponseEntity.ok(response);
		
	}

}
