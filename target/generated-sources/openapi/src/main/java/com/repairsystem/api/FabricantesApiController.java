package com.repairsystem.api;

import com.repairsystem.dto.FabricanteRequestDTO;
import com.repairsystem.dto.FabricanteResponseDTO;
import com.repairsystem.dto.PageFabricanteResponseDTO;


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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-23T22:50:24.713899220-03:00[America/Sao_Paulo]", comments = "Generator version: 7.8.0")
@Controller
@RequestMapping("${openapi.repairTips.base-path:/api}")
public class FabricantesApiController implements FabricantesApi {

    private final FabricantesApiDelegate delegate;

    public FabricantesApiController(@Autowired(required = false) FabricantesApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new FabricantesApiDelegate() {});
    }

    @Override
    public FabricantesApiDelegate getDelegate() {
        return delegate;
    }

}
