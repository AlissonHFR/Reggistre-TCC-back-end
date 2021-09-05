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

import br.fai.reggistre.api.service.AwardService;
import br.fai.reggistre.model.entities.Premio;


@RestController
@RequestMapping("/api/v1/award")
@CrossOrigin(origins = "*")
public class AwardRestController {
	
	@Autowired
	private AwardService awardService;
	
	@GetMapping("/read-all")
	public ResponseEntity< List<Premio>> readAll(){
		
		List<Premio> premioList = awardService.readAll();
		
		if(premioList == null || premioList.size() == 0) {
			return ResponseEntity.ok(null);
		}else {
			return ResponseEntity.ok(premioList);
					
		}
		
	}
	
	@GetMapping("/read-by-id/{id}")
	public ResponseEntity<Premio> readById(@PathVariable("id")Long id){
		
		Premio premio = awardService.readById(id);
		
		if(premio == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(premio);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Boolean> update(@RequestBody Premio entity){
		
		boolean response = awardService.update(entity);
		
		return ResponseEntity.ok(response);
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<Long> create(@RequestBody Premio entity){
		
		Long id = awardService.create(entity);
		
		return ResponseEntity.ok(id);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id")Long id){
		
		boolean response = awardService.deleteById(id);
		
		return ResponseEntity.ok(response);
		
	}

}
