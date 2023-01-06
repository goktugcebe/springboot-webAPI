package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;

    @Autowired
    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();//Veritabanindan gelen 3 tane marka var.
        List<GetAllBrandsResponse> brandsResponse = new ArrayList<>(); //Bos bir liste olusuturuyoruz.
        for (Brand brand : brands) {//Foreach ile Veritabanindan gelen listeyi dolasiyorum.
            GetAllBrandsResponse responseItem = new GetAllBrandsResponse();//Her dolastigimdan bir eleman olusturuyorum.
            responseItem.setId(brand.getId());//brand id ve name i yeni olusturulan dizideki id ve namelere set ediyoruz.
            responseItem.setName(brand.getName());
            brandsResponse.add(responseItem);
        }
        //business rules
        return brandsResponse;
    }
    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        Brand brand = new Brand();
        brand.setName(createBrandRequest.getName());
        this.brandRepository.save(brand);
    }
}
