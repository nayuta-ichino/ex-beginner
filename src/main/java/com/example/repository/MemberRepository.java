package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Member;

@Repository
public class MemberRepository {
	// Domain Memberを参照
	@Autowired
	private NamedParameterJdbcTemplate template;

	// RowMapper
	private static final RowMapper<Member> MEMBER_ROW_MAPPER = (rs, i) -> {
		Member member = new Member();
		member.setId(rs.getInt("id"));
		member.setName(rs.getString("name"));
		member.setAge(rs.getInt("age"));
		member.setDepId(rs.getInt("dep_id"));

		return member;
	};

	/**
	 * あいまい検索を行う
	 * 
	 * @param id ID
	 * @return ユーザー情報
	 */
	public List<Member> searchAll(String search) {
		String sql = "SELECT id, name, age, dep_id FROM members WHERE name LIKE :search ORDER BY age;";

		SqlParameterSource param = new MapSqlParameterSource().addValue("search", "%" + search + "%");

		List<Member> memberList = template.query(sql, param, MEMBER_ROW_MAPPER);

		return memberList;
		
	}
}
