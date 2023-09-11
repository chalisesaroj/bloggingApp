package com.udemy.learn.blogging.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.learn.blogging.entity.post;
import com.udemy.learn.blogging.payload.pageResponse;
import com.udemy.learn.blogging.payload.postDto;
import com.udemy.learn.blogging.repository.postRepository;

@RestController
@RequestMapping("/api/post")
public class PostController {
	@Autowired
	private postRepository postrepository;
	
	
	
@PostMapping("createPost")
	public  ResponseEntity<String>createPost(@RequestBody post post) {
		try {
		postrepository.save(post);
		return ResponseEntity.ok("Succesfully Created");
		}catch(Exception e){return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add transaction");
			
		}
	}
@GetMapping()
public  pageResponse getPost(@RequestParam(value="pageNumber",defaultValue="0",required=false)int pageNumber,
		@RequestParam (value="pageSize" ,defaultValue="5",required=false) int pagesize,
		@RequestParam(value="sortBy",defaultValue="id",required=false)String sortBy,
		@RequestParam(value="sortDirection",defaultValue="asc",required=false)String sortDirection
		) {
	Sort sort=sortDirection.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
	Pageable pageable=PageRequest.of(pageNumber, pagesize, sort );
	Page page=postrepository.findAll(pageable);
	List<post>list=page.getContent();
	pageResponse pageresponse=new pageResponse();
	pageresponse.setContents(list);
	pageresponse.setNoOfPage(page.getTotalPages());
	pageresponse.setPageNumber(page.getNumber());
	pageresponse.setPageSize(page.getSize());
	pageresponse.setLast(page.isLast());
	pageresponse.setNoOfElements(page.getNumberOfElements());
	

//System.out.println(list);
		
	
	return pageresponse;
	
}

@GetMapping("/{id}")
public  post getPostbyId(@PathVariable ("id") long id) {
	
post POST =postrepository.findById(id).get();
	
	
	return POST;
	
}
//update API
@PutMapping("/{id}")
public void updatePostbyId(@RequestBody post newpost, @PathVariable ("id") long id) {
	post p11 =postrepository.findById(id).get();
		p11.setContent(newpost.getContent());
		p11.setDescription(newpost.getDescription());
		p11.setTitle(newpost.getTitle());
		postrepository.save(p11);
}
//delete API
@DeleteMapping("/{id}")
public ResponseEntity<String>deletebyId(@PathVariable("id") long id){
	Optional<post>p1=postrepository.findById(id);
	if(p1.isPresent()) {
		postrepository.deleteById(id);
		return new ResponseEntity("Succesfully Deleted",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("couldnot be deleted",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}


}
