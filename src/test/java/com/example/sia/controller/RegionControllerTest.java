package com.example.sia.controller;

import com.example.sia.dto.RegionDto;
import com.example.sia.helper.RegionDtoHelper;
import com.example.sia.service.RegionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@Transactional
class RegionControllerTest {
	@Autowired
	MockMvc mockMvc;

	@Autowired
	private RegionService regionService;

	@Autowired
	private WebApplicationContext ctx;

	private RegionDtoHelper regionDtoHelper;

	@BeforeEach() //Junit4의 @Before
	public void setup() {
		this.regionDtoHelper = new RegionDtoHelper();
	}
	@DisplayName("해당 지역의 정보를 저장하고 해당 아이디를 가져온다.")
	@Test
	void saveRegion() throws Exception {
		//given
		String name = "북구청";
		RegionDto regionDto = regionDtoHelper.createRegion(name,3);
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(regionDto);
		// when
		mockMvc.perform(MockMvcRequestBuilders.post("/regions")
				.content(jsonData).contentType(MediaType.APPLICATION_JSON))
				// then
				.andExpect(status().isOk())
				.andExpect(content().string("1"))
				.andExpect(handler().handlerType(RegionController.class))
				.andDo(print());
	}

	@Test
	void getRegion() {
	}
}