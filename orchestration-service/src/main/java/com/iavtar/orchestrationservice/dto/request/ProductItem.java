package com.iavtar.orchestrationservice.dto.request;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductItem {

	private Long productId;
	private String productName;
	private Long productQuantity;
	private BigDecimal pricePerUnit;
	private String imageUrl;
}
