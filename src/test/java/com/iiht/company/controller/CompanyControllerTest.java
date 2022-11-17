//package com.iiht.company.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.iiht.company.pojo.Company;
//import com.iiht.company.repository.CompanyRepository;
//import com.iiht.company.service.CompanyService;
//import org.junit.jupiter.api.Test;
//import org.mockito.Matchers;
//import org.mockito.Mockito;
//import org.skyscreamer.jsonassert.JSONAssert;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//@WebMvcTest(CompanyController.class)
//public class CompanyControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private CompanyService companyService;
//
//    @MockBean
//    private CompanyRepository companyRepository;
//
//    @Test
//    void addCompanyTest_success() throws Exception {
//        String id = UUID.randomUUID().toString();
//        String companyCode = "CTS";
//
//        Company company = new Company();
//        company.setId(id);
//        company.setCompanyCode(companyCode);
//        company.setCompanyCEO("Nikhil");
//        company.setCompanyName("Cognizant");
//        company.setCompanyTurnOver("10bn");
//        company.setStockExchange("NSE");
//        company.setWebsite("https://cognizant.com");
//
//        Mockito.when(companyRepository.findByCompanyCode(Matchers.anyString())).thenReturn(Optional.empty());
//        Mockito.when(companyRepository.save(Matchers.any(Company.class))).thenReturn(company);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String content = objectMapper.writeValueAsString(company);
//
//        RequestBuilder request = MockMvcRequestBuilders
//                .post("/api/v1.0/market/company/register")
//                .content(content)
//                .contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(request).andReturn();
//        String responseAsString = result.getResponse().getContentAsString();
//        System.out.println("Response: " + responseAsString);
//
//        String expectedStr = "{\"message\":\"Company registration request completed successfully!\"}";
//
//        JSONAssert.assertEquals(String.valueOf(201), String.valueOf(result.getResponse().getStatus()),true);
//        JSONAssert.assertEquals(expectedStr, responseAsString, false);
//    }
//
//    @Test
//    void addCompanyTest_companyAlreadyPresent() throws Exception {
//        String id = UUID.randomUUID().toString();
//        String companyCode = "CTS";
//
//        Company company = new Company();
//        company.setId(id);
//        company.setCompanyCode(companyCode);
//        company.setCompanyCEO("Nikhil");
//        company.setCompanyName("Cognizant");
//        company.setCompanyTurnOver("10bn");
//        company.setStockExchange("NSE");
//        company.setWebsite("https://cognizant.com");
//
//        Mockito.when(companyService.isCompanyAlreadyPresent(Matchers.anyString())).thenReturn(Boolean.TRUE);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String content = objectMapper.writeValueAsString(company);
//
//        RequestBuilder request = MockMvcRequestBuilders
//                .post("/api/v1.0/market/company/register")
//                .content(content)
//                .contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(request).andReturn();
//        String responseAsString = result.getResponse().getContentAsString();
//        System.out.println("Response: " + responseAsString);
//
//        String expectedStr = "{\"message\":\"Company already registered with company code - CTS\"}";
//
//        JSONAssert.assertEquals(String.valueOf(400), String.valueOf(result.getResponse().getStatus()),true);
//        JSONAssert.assertEquals(expectedStr, responseAsString, false);
//    }
//
//    @Test
//    void addCompanyTest_badRequest() throws Exception {
//        String id = UUID.randomUUID().toString();
//        String companyCode = "CTS";
//
//        Company company = new Company();
//        company.setId(id);
//        company.setCompanyCode(companyCode);
//        company.setCompanyCEO("Nikhil");
//        company.setCompanyName("Cognizant");
//        company.setCompanyTurnOver("10bn");
//        company.setStockExchange("NSE");
//        company.setWebsite("https://cognizant.com");
//
//        Mockito.when(companyService.isCompanyAlreadyPresent(Matchers.anyString())).thenThrow(new IllegalStateException());
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String content = objectMapper.writeValueAsString(company);
//
//        RequestBuilder request = MockMvcRequestBuilders
//                .post("/api/v1.0/market/company/register")
//                .content(content)
//                .contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(request).andReturn();
//        String responseAsString = result.getResponse().getContentAsString();
//        System.out.println("Response: " + responseAsString);
//
//        String expectedStr = "{\"message\":\"java.lang.IllegalStateException\"}";
//
//        JSONAssert.assertEquals(String.valueOf(400), String.valueOf(result.getResponse().getStatus()),true);
//        JSONAssert.assertEquals(expectedStr, responseAsString, false);
//    }
//
//    @Test
//    void addCompanyTest_handleException() throws Exception {
//        String id = UUID.randomUUID().toString();
//        String companyCode = "CTS";
//
//        Company company = new Company();
//        company.setId(id);
//        company.setCompanyCode(companyCode);
//        company.setCompanyCEO("Vaibhab");
//        company.setCompanyName("Cognizant");
//        company.setCompanyTurnOver("10bn");
//        company.setStockExchange("NSE");
//        company.setWebsite("https://cognizant.com");
//
//        Mockito.when(companyService.isCompanyAlreadyPresent(Matchers.anyString())).thenThrow(new IllegalArgumentException());
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String content = objectMapper.writeValueAsString(company);
//
//        RequestBuilder request = MockMvcRequestBuilders
//                .post("/api/v1.0/market/company/register")
//                .content(content)
//                .contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(request).andReturn();
//        String responseAsString = result.getResponse().getContentAsString();
//        System.out.println("Response: " + responseAsString);
//
//        JSONAssert.assertEquals(String.valueOf(500), String.valueOf(result.getResponse().getStatus()),true);
//    }
//
//    @Test
//    void listOfCompanyTest_found() throws Exception {
//        List<Company> companyList = new ArrayList<>();
//        Company company = new Company();
//        company.setId("sfsafasf");
//        company.setCompanyCode("CTS");
//        company.setCompanyCEO("Vaibhav");
//        company.setCompanyName("Cognizant");
//        company.setCompanyTurnOver("10bn");
//        company.setStockExchange("NSE");
//        company.setWebsite("https://cognizant.com");
//        companyList.add(company);
//
//        Mockito.when(companyService.findAll()).thenReturn(companyList);
//
//        RequestBuilder request = MockMvcRequestBuilders
//                .get("/api/v1.0/market/company/getall")
//                .accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(request).andReturn();
//        String responseAsString = result.getResponse().getContentAsString();
//        System.out.println("Response: " + responseAsString);
//
//        String expectedStr = "{\"message\":\"Successfully returned 1 company(s)!\",\"companies\":[{\"id\":\"sfsafasf\",\"companyCode\":\"CTS\",\"companyName\":\"Cognizant\",\"companyCEO\":\"Nikhil\",\"companyTurnOver\":\"10bn\",\"website\":\"https://cognizant.com\",\"stockExchange\":\"NSE\"}],\"numberOfCompany\":1}";
//
//        JSONAssert.assertEquals(String.valueOf(200), String.valueOf(result.getResponse().getStatus()),true);
//        JSONAssert.assertEquals(expectedStr, responseAsString, false);
//    }
//
//    @Test
//    void listOfCompanyTest_notFound() throws Exception {
//        List<Company> companyList = new ArrayList<>();
//
//        Mockito.when(companyService.findAll()).thenReturn(companyList);
//
//        RequestBuilder request = MockMvcRequestBuilders
//                .get("/api/v1.0/market/company/getall")
//                .accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(request).andReturn();
//
//        JSONAssert.assertEquals(String.valueOf(204), String.valueOf(result.getResponse().getStatus()),true);
//    }
//
//    @Test
//    void listOfCompanyTest_failedToGet() throws Exception {
//        Mockito.when(companyService.findAll()).thenThrow(new IllegalArgumentException());
//
//        RequestBuilder request = MockMvcRequestBuilders
//                .get("/api/v1.0/market/company/getall")
//                .accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(request).andReturn();
//        String responseAsString = result.getResponse().getContentAsString();
//        System.out.println("Response: " + responseAsString);
//
//        String expectedStr = "{\"message\":\"Failed to get company(s)!\"}";
//
//        JSONAssert.assertEquals(String.valueOf(500), String.valueOf(result.getResponse().getStatus()),true);
//        JSONAssert.assertEquals(expectedStr, responseAsString, false);
//    }
//
//    @Test
//    void viewCompanyTest_found() throws Exception {
//        Company company = new Company();
//        company.setId("sfsafasf");
//        company.setCompanyCode("CTS");
//        company.setCompanyCEO("Vaibhav");
//        company.setCompanyName("Cognizant");
//        company.setCompanyTurnOver("10bn");
//        company.setStockExchange("NSE");
//        company.setWebsite("https://cognizant.com");
//
//        Mockito.when(companyService.findByCompanyCode(Matchers.anyString())).thenReturn(Optional.of(company));
//
//        RequestBuilder request = MockMvcRequestBuilders
//                .get("/api/v1.0/market/company/info/CTS")
//                .accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(request).andReturn();
//        String responseAsString = result.getResponse().getContentAsString();
//        System.out.println("Response: " + responseAsString);
//
//        String expectedStr = "{\"id\":\"sfsafasf\",\"companyCode\":\"CTS\",\"companyName\":\"Cognizant\",\"companyCEO\":\"Nikhil\",\"companyTurnOver\":\"10bn\",\"website\":\"https://cognizant.com\",\"stockExchange\":\"NSE\"}";
//
//        JSONAssert.assertEquals(String.valueOf(200), String.valueOf(result.getResponse().getStatus()),true);
//        JSONAssert.assertEquals(expectedStr, responseAsString, false);
//    }
//
//    @Test
//    void viewCompanyTest_notFound() throws Exception {
//        Mockito.when(companyService.findByCompanyCode(Matchers.anyString())).thenReturn(Optional.empty());
//
//        RequestBuilder request = MockMvcRequestBuilders
//                .get("/api/v1.0/market/company/info/CTS")
//                .accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(request).andReturn();
//
//        JSONAssert.assertEquals(String.valueOf(204), String.valueOf(result.getResponse().getStatus()),true);
//    }
//
//    @Test
//    void viewCompanyTest_failed() throws Exception {
//        Mockito.when(companyService.findByCompanyCode(Matchers.anyString())).thenThrow(new IllegalArgumentException());
//
//        RequestBuilder request = MockMvcRequestBuilders
//                .get("/api/v1.0/market/company/info/CTS")
//                .accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(request).andReturn();
//
//        JSONAssert.assertEquals(String.valueOf(500), String.valueOf(result.getResponse().getStatus()),true);
//    }
//
//    @Test
//    void isCompanyPresentTest_found() throws Exception {
//        Company company = new Company();
//        company.setId("sfsafasf");
//        company.setCompanyCode("CTS");
//        company.setCompanyCEO("Vaibhav");
//        company.setCompanyName("Cognizant");
//        company.setCompanyTurnOver("10bn");
//        company.setStockExchange("NSE");
//        company.setWebsite("https://cognizant.com");
//
//        Mockito.when(companyService.findByCompanyCode(Matchers.anyString())).thenReturn(Optional.of(company));
//
//        RequestBuilder request = MockMvcRequestBuilders
//                .get("/api/v1.0/market/company/isCompanyPresent/CTS")
//                .accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(request).andReturn();
//        String responseAsString = result.getResponse().getContentAsString();
//        System.out.println("Response: " + responseAsString);
//
//        JSONAssert.assertEquals(String.valueOf(200), String.valueOf(result.getResponse().getStatus()),true);
//    }
//
//    @Test
//    void isCompanyPresentTest_notFound() throws Exception {
//        Mockito.when(companyService.findByCompanyCode(Matchers.anyString())).thenReturn(Optional.empty());
//
//        RequestBuilder request = MockMvcRequestBuilders
//                .get("/api/v1.0/market/company/isCompanyPresent/CTS")
//                .accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(request).andReturn();
//        String responseAsString = result.getResponse().getContentAsString();
//        System.out.println("Response: " + responseAsString);
//
//        JSONAssert.assertEquals(String.valueOf(200), String.valueOf(result.getResponse().getStatus()),true);
//    }
//
//    @Test
//    void isCompanyPresentTest_failed() throws Exception {
//        Mockito.when(companyService.findByCompanyCode(Matchers.anyString())).thenThrow(new IllegalArgumentException());
//
//        RequestBuilder request = MockMvcRequestBuilders
//                .get("/api/v1.0/market/company/isCompanyPresent/CTS")
//                .accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(request).andReturn();
//        String responseAsString = result.getResponse().getContentAsString();
//        System.out.println("Response: " + responseAsString);
//
//        JSONAssert.assertEquals(String.valueOf(500), String.valueOf(result.getResponse().getStatus()),true);
//    }
//
//    @Test
//    void deleteCompanyTest() throws Exception {
//        Mockito.when(companyService.deleteCompany(Matchers.anyString())).thenReturn("Company deleted successfully!");
//
//        RequestBuilder request = MockMvcRequestBuilders
//                .delete("/api/v1.0/market/company/delete/JHGJH12313")
//                .accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(request).andReturn();
//        String responseAsString = result.getResponse().getContentAsString();
//        System.out.println("Response: " + responseAsString);
//
//        String expectedStr = "{\"message\":\"Company deleted successfully!\"}";
//
//        JSONAssert.assertEquals(String.valueOf(200), String.valueOf(result.getResponse().getStatus()),true);
//        JSONAssert.assertEquals(expectedStr, responseAsString, false);
//    }
//
//    @Test
//    void deleteCompanyTest_failedToDelete() throws Exception {
//        Mockito.when(companyService.deleteCompany(Matchers.anyString())).thenThrow(new IllegalArgumentException());
//
//        RequestBuilder request = MockMvcRequestBuilders
//                .delete("/api/v1.0/market/company/delete/JHGJH12313")
//                .accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(request).andReturn();
//        String responseAsString = result.getResponse().getContentAsString();
//        System.out.println("Response: " + responseAsString);
//
//        String expectedStr = "{\"message\":\"Error while processing request to delete company with id - JHGJH12313.\"}";
//
//        JSONAssert.assertEquals(String.valueOf(500), String.valueOf(result.getResponse().getStatus()),true);
//        JSONAssert.assertEquals(expectedStr, responseAsString, false);
//    }
//}
