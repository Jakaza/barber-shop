package tut.ac.za.barbershop.service;


import org.springframework.stereotype.Service;
import tut.ac.za.barbershop.dto.HairStyleDto;
import tut.ac.za.barbershop.entities.HairStyle;
import tut.ac.za.barbershop.repository.HairStyleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HaireStyleService {

    private final HairStyleRepository hairStyleRepository;

    public HaireStyleService(HairStyleRepository hairStyleRepository) {
        this.hairStyleRepository = hairStyleRepository;
    }

    public void addNewHairStyle(HairStyleDto hairStyleDto){
        HairStyle hairStyle = new HairStyle();
        hairStyle.setName(hairStyleDto.getName());
        hairStyle.setPrice(hairStyleDto.getPrice());
        hairStyleRepository.save(hairStyle);
    }

    public List<HairStyle> findAllHairStyles() {
        return hairStyleRepository.findAll();
    }

    public void updateHairStyle(HairStyleDto hairStyleDto) {
        Optional<HairStyle> hairStle = hairStyleRepository.findById(hairStyleDto.getId());
        if(hairStle.isPresent()){
            HairStyle hairStyle = hairStle.get();
            hairStyle.setName(hairStyleDto.getName());
            hairStyle.setPrice(hairStyleDto.getPrice());
            hairStyleRepository.save(hairStyle);
        }

    }
}
