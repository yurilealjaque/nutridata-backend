package com.example.nutridata.saleDataile;

import com.example.nutridata.saleDataile.dto.SaleDetailRequest;
import com.example.nutridata.saleDataile.dto.SaleDetailResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleDetailRepository extends JpaRepository<SaleDetail, Long> {
}
