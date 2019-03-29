package yjh.service;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import yjh.dao.ClothesDAO;
import yjh.model.Clothes;

import javax.annotation.Resource;

@Service
public class ClothesService {

    @Resource
    private ClothesDAO clothesDAO;


    public int addClothes(Clothes clothes) {
        return clothesDAO.addClothes(clothes);
    }

    public int deleteById(int clothesId) {
        return clothesDAO.deleteById(clothesId);
    }

    public Clothes getById(int clothesId) {
        return clothesDAO.getById(clothesId);
    }
}
