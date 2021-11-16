package com.example.minam.apply;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ApplyController {
	
private ApplyRepository repo;
	
	@Autowired
	public ApplyController(ApplyRepository repo) {
		this.repo = repo;
	}
	
	// 목록조회
	// GET/applys
	@GetMapping(value = "/applys")
	public List<Apply> getApplys() throws InterruptedException {
		return repo.findAll(Sort.by("id").descending());
	}
	
	// 추가
		// POST / applys
		@PostMapping(value = "/applys")
		public Apply addApply(@RequestBody Apply apply, HttpServletResponse res) throws InterruptedException {
			// 입력받은 데이터로 객체를 생성
			Apply applyItem = Apply.builder().clinicName(apply.getClinicName()).clinicSector(apply.getClinicSector()).clinicLocate(apply.getClinicLocate()).dateOfEstablishment(apply.getDateOfEstablishment()).registrationNumber(apply.getRegistrationNumber()).phone(apply.getPhone()).email(apply.getEmail()).applicantName(apply.getApplicantName()).admissionApplicationDate(apply.getAdmissionApplicationDate()).build();
			// 목록 객체 추가
			// repository.save(entity)
			Apply applySaved = repo.save(applyItem);

			// 리소스 생성됨
			// res.setStatus(201);
			res.setStatus(HttpServletResponse.SC_CREATED);
			
			return applySaved;
		}
}
