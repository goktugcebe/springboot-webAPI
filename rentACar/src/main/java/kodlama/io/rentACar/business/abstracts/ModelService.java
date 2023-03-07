package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll(); //response
    void add(CreateModelRequest createModelRequest);

}
