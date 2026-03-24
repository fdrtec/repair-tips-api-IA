package com.repairsystem.api;

import com.repairsystem.dto.PagePecaResponseDTO;
import com.repairsystem.dto.PecaRequestDTO;
import com.repairsystem.dto.PecaResponseDTO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-23T23:19:45.937138696-03:00[America/Sao_Paulo]", comments = "Generator version: 7.8.0")
@Controller
@RequestMapping("${openapi.repairTips.base-path:/api}")
public class PeasApiController implements PeasApi {

    private final PeasApiDelegate delegate;

    public PeasApiController(@Autowired(required = false) PeasApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new PeasApiDelegate() {});
    }

    @Override
    public PeasApiDelegate getDelegate() {
        return delegate;
    }

}
