package com.shiva.practice.mapper;

import com.shiva.practice.mvp.model.Cake;
import com.shiva.practice.mvp.model.CakeResponse;
import com.shiva.practice.mvp.model.CakeResponseCakes;
import com.shiva.practice.mvp.model.Storage;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CakeMapper {

    @Inject
    public CakeMapper() {
    }

    public List<Cake> mapCakes(Storage storage, CakeResponse response) {

        List<Cake> cakeList = new ArrayList<>();
        if (response != null) {
            CakeResponseCakes[] responseCakes = response.getCakes();
            if (responseCakes != null) {
                for (CakeResponseCakes cakeResponseCakes : responseCakes) {
                    Cake myCake = new Cake();
                    myCake.setId(cakeResponseCakes.getId());
                    myCake.setDetailDescription(cakeResponseCakes.getDetailDescription());
                    myCake.setPreviewDescription(cakeResponseCakes.getPreviewDescription());
                    myCake.setImageUrl(cakeResponseCakes.getImage());
                    myCake.setTitle(cakeResponseCakes.getTitle());
                    storage.addCake(myCake);
                    cakeList.add(myCake);
                }
            }
        }
        return cakeList;
    }
}
