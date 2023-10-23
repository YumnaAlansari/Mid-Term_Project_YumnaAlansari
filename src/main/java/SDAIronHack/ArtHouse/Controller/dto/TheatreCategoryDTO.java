package SDAIronHack.ArtHouse.Controller.dto;

import lombok.Getter;

@Getter
public class TheatreCategoryDTO {
    private String category;


    public TheatreCategoryDTO(){}

    public TheatreCategoryDTO(String category) {
        this.category = category;
    }

}
