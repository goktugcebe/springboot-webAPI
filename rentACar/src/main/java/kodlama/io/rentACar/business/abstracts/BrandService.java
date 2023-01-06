package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import java.util.List;
public interface BrandService {
    List<GetAllBrandsResponse> getAll(); //response
    void add(CreateBrandRequest createBrandRequest);
}
