package dev.orewaee.mosstures.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dev.orewaee.mosstures.services.TextureService;

import java.io.IOException;

@CrossOrigin
@RestController
@AllArgsConstructor
public class TextureController {
    private TextureService textureService;

    @GetMapping(value = "/texture/{name}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getTexture(@PathVariable String name) throws IOException {
        return textureService.getTexture(name);
    }

    @GetMapping(value = "/texture/{name}/{size}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getTexture(@PathVariable String name, @PathVariable Integer size) throws IOException {
        return textureService.getTexture(name, size);
    }
}
