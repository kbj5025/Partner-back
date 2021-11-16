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
	
	// �����ȸ
	// GET/applys
	@GetMapping(value = "/applys")
	public List<Apply> getApplys() throws InterruptedException {
		return repo.findAll(Sort.by("id").descending());
	}
	
	// �߰�
		// POST / applys
		@PostMapping(value = "/applys")
		public Apply addApply(@RequestBody Apply apply, HttpServletResponse res) throws InterruptedException {
			// �Է¹��� �����ͷ� ��ü�� ����
			Apply applyItem = Apply.builder().clinicName(apply.getClinicName()).clinicSector(apply.getClinicSector()).clinicLocate(apply.getClinicLocate()).dateOfEstablishment(apply.getDateOfEstablishment()).registrationNumber(apply.getRegistrationNumber()).phone(apply.getPhone()).email(apply.getEmail()).applicantName(apply.getApplicantName()).admissionApplicationDate(apply.getAdmissionApplicationDate()).build();
			// ��� ��ü �߰�
			// repository.save(entity)
			Apply applySaved = repo.save(applyItem);

			// ���ҽ� ������
			// res.setStatus(201);
			res.setStatus(HttpServletResponse.SC_CREATED);
			
			return applySaved;
		}
}
