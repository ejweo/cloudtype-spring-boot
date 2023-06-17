package io.cloudtype.waitlist.controller;

import io.cloudtype.waitlist.exception.ResourceNotFoundException;
import io.cloudtype.waitlist.model.Guest;
import io.cloudtype.waitlist.model.Member;
import io.cloudtype.waitlist.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Member")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping
    public List<Member> getAllMember() {
        return memberRepository.findAll();
    }

    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberRepository.save(member);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getGuestById(@PathVariable Long id) {
        Member member  = memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Member not found."));
        return ResponseEntity.ok(member);
    }

    @PutMapping("{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member memberInfo) {
        Member updateMember = memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Guest not found."));
        updateMember.setName(memberInfo.getName());
        updateMember.setNum(memberInfo.getNum());
        updateMember.setPhoneNum(memberInfo.getPhoneNum());

        memberRepository.save(updateMember);

        return ResponseEntity.ok(updateMember);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteGuest(@PathVariable Long id) {

        Member member = memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Guest not found."));

        memberRepository.delete(member);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
