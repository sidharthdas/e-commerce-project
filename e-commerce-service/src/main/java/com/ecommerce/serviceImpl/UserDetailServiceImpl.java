package com.ecommerce.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.CartDAO;
import com.ecommerce.dao.ProductDAO;
import com.ecommerce.dao.UserDetailDAO;
import com.ecommerce.dao.UserDetailinfoDAO;
import com.ecommerce.dao.WishListDAO;
import com.ecommerce.dto.PriceWithDiscountDTO;
import com.ecommerce.dto.ProductWithoutQuantityDTO;
import com.ecommerce.dto.UserDetail1DTO;
import com.ecommerce.dto.UserDetailDTO;
import com.ecommerce.dto.UserEmailAndCartDTO;
import com.ecommerce.dto.UserNameAndProductDTO;
import com.ecommerce.entity.Cart;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.UserDetail;
import com.ecommerce.entity.UserDetailInfo;
import com.ecommerce.entity.WishList;
import com.ecommerce.service.UserDetailService;
import com.ecommerce.utils.SendingEmailUtil;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service("user")
public class UserDetailServiceImpl implements UserDetailService {
	
	private static String OTP =  null;
	private static String currentUserEMail =  null;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private WishListDAO wishListDAO;
	@Autowired
	private UserDetailDAO userDetailDAO;

	@Autowired
	private UserDetailinfoDAO userDetailinfoDAO;

	@Autowired
	private CartDAO cartDAO;

	@Autowired
	private UserDetailinfoDAO userDetailInfoDAO;

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private SendingEmailUtil sendingEmailUtil;
	
	@Value("${college.name}")
	private String collegeName;

	@Override
	public UserDetailInfo addUser(UserDetailDTO userDetailDTO) {
		// TODO Auto-generated method stub
		if (Objects.isNull(userDetailDTO)) {
			return null;
		}

		if (userDetailDAO.userCount(userDetailDTO.getEmail()) == 0) {
			Cart cart = new Cart();
			WishList wishList = new WishList();
			cartDAO.save(cart);
			wishListDAO.save(wishList);
			UserDetail userDetail = new UserDetail();
			userDetail.setCart(cart);
			userDetail.setPassword(userDetailDTO.getPassword());
			userDetail.setUserName(userDetailDTO.getEmail());
			userDetail.setWishList(wishList);

			userDetailDAO.save(userDetail);

			UserDetailInfo userDetailInfo = new UserDetailInfo();
			userDetailInfo.setEmail(userDetailDTO.getEmail());
			userDetailInfo.setName(userDetailDTO.getName());
			userDetailInfo.setPhoneNum(userDetailDTO.getPhoneNum());

			return userDetailinfoDAO.save(userDetailInfo);
		}
		return null;
	}

	@Override
	public List<String> getAllName() {
		// TODO Auto-generated method stub
		return userDetailDAO.allUserNames();
	}

	@Override
	public void addDummyUsers() {

		List<UserDetailDTO> dummyUsers = new ArrayList<>();
		dummyUsers.add(new UserDetailDTO("Sidharth", "sidharthdas.1995@gmail.com", 70084, "test@123"));
		dummyUsers.add(new UserDetailDTO("Sagar", "sagardas.195@hotmail.com", 989898, "test@123"));
		dummyUsers.add(new UserDetailDTO("Anjali", "anjalidawadi@yahoo.com", 567890, "test@123"));
		dummyUsers.add(new UserDetailDTO("Ram", "ram@gmail.com", 567890, "test@123"));
		dummyUsers.add(new UserDetailDTO("Sita", "sita@gmail.com", 567890, "test@123"));
		dummyUsers.add(new UserDetailDTO("Gita", "gita@gmail.com", 567890, "test@123"));
		dummyUsers.add(new UserDetailDTO("Dev", "dev@hotmail.com", 567890, "test@123"));
		dummyUsers.add(new UserDetailDTO("Koustav", "koustav@yahoo.com", 567890, "test@123"));
		dummyUsers.add(new UserDetailDTO("Ajay", "ajay@outook.com", 567890, "test@123"));
		dummyUsers.add(new UserDetailDTO("Amlan", "amlan@outlook.com", 567890, "test@123"));

		dummyUsers.forEach(user -> {
			addUser(user);
		});

	}

	@Override
	public Map<String, String> getUserNameAndEmail() {
		// TODO Auto-generated method stub
		Map<String, String> userNamesAndEmail = new HashMap<>();
		List<UserDetailInfo> allUser = userDetailInfoDAO.getAllUser();

		allUser.forEach(user -> {
			userNamesAndEmail.put(user.getEmail(), user.getName());
		});
		return userNamesAndEmail;
	}

	@Override
	public List<String> getUserEmail() {
		List<String> userEmail1 = new ArrayList<String>();
		List<UserDetailInfo> allUser = userDetailInfoDAO.getAllUser();

		allUser.forEach(user -> {
			userEmail1.add(user.getEmail());
		});

		List<String> userEmail2 = new ArrayList<String>();
		for (String element : userEmail1) {
			if (element.contains("gmail")) {
				userEmail2.add(element);
			}

		}
		return userEmail2;
	}

	@Override
	public Map<String, Integer> getDomainCount() {

		Map<String, Integer> domainCount = new HashMap<>();

		List<UserDetailInfo> allUser = userDetailInfoDAO.getAllUser();

		allUser.forEach(user -> {

			String[] email = user.getEmail().split("@");
			String[] domain = email[1].split("\\.");
			String domainName = domain[0];

			if (domainCount.containsKey(domainName)) {
				domainCount.put(domainName, domainCount.get(domainName) + 1);

			} else {
				domainCount.put(domainName, 1);
			}
		});
		return domainCount;
	}

	@Override
	public Cart getUserCartByID(long id) {
		Optional<UserDetail> userDetail = userDetailDAO.findById(id);
		if (Objects.isNull(userDetail)) {
			return null;
		}
		return userDetail.get().getCart();
	}

	@Override
	public List<Cart> getAllCartDetail() {
		List<UserDetail> allUsers = userDetailDAO.allUserDetail();
		List<Cart> allCarts = new ArrayList<>();
		for (UserDetail users : allUsers) {
			allCarts.add(users.getCart());
		}
		return allCarts;
	}

	@Override
	public List<UserEmailAndCartDTO> getUserCart(List<String> userName) {
		List<UserDetail> allUser = userDetailDAO.allUserDetail();
		List<UserEmailAndCartDTO> userEmailAndCarts = new ArrayList<>();
		for (UserDetail u : allUser) {
			if (userName.contains(u.getUserName())) {
				Cart cart = new Cart();
				cart = u.getCart();
				userEmailAndCarts.add(new UserEmailAndCartDTO(u.getUserName(), cart));

			}
		}
		return userEmailAndCarts;
	}

	@Override
	public void getUserCartDetails(long userId, long product_Id) {
		// TODO Auto-generated method stub
		int countProductId = productDAO.countProductById(product_Id);
		if (countProductId == 0) {
			return;
		}
		List<UserDetail> allUser = userDetailDAO.getUserById(userId);
		List<Product> allProduct = productDAO.getProductById(product_Id);

		allUser.get(0).getCart().getProducts().add(allProduct.get(0));

		List<Integer> quantity = productDAO.quantityOfProductById(product_Id);

		int result = productDAO.updateProductQuantityByProductId(quantity.get(0) - 1, product_Id);
		if (result != 0) {
			System.out.println("updated");
		}
	}

	@Override
	public List<UserDetail> getUserDetailWithSpecificProduct(String productName) {
		// TODO Auto-generated method stub
		List<UserDetail> allUser = userDetailDAO.allUserDetail();
		List<UserDetail> specificUser = new ArrayList<>();
		for (UserDetail u : allUser) {
			if (u.getCart().equals(null)) {
				return null;
			}
			for (Product p : u.getCart().getProducts()) {
				if (p.getProdName().equalsIgnoreCase(productName)) {
					specificUser.add(u);
				}
			}
		}
		return specificUser;
	}

	@Override
	public List<UserDetail> getUserDetailWithMorethantwoProduct() {
		// TODO Auto-generated method stub
		List<UserDetail> allUser = userDetailDAO.allUserDetail();
		List<UserDetail> userwithmorethantwoProduct = new ArrayList<>();
		for (UserDetail u : allUser) {
			if (u.getCart().getProducts().size() >= 2) {
				userwithmorethantwoProduct.add(u);
			}
		}
		return userwithmorethantwoProduct;
	}

	@Override
	public void getUserCartProductQuantityDetails(long userId, long productId, int productQuantity) {
		// TODO Auto-generated method stub
		int countProductId = productDAO.countProductById(productId);
		if (countProductId == 0) {
			return;
		}

		List<Integer> countQuantity = productDAO.quantityOfProductById(productId);
		if ((countQuantity.get(0) < productQuantity)) {
			return;
		}

		for (int i = 0; i < productQuantity; i++) {
			getUserCartDetails(userId, productId);
		}

	}

	@Override
	public float getUserCartValue(long userId) {
		// TODO Auto-generated method stub
		String s = "";
		List<UserDetail> allUser = userDetailDAO.getUserById(userId);
		Collection<Product> getallProduct = allUser.get(0).getCart().getProducts();
		// List<Integer> quantity = productDAO.quantityOfProductById());
		float price = 0;
		for (Product p : getallProduct) {
			price = price + productDAO.getProductPricebyId(p.getProductId());
		}

		return price;
	}

	@Override
	public Map<String, Integer> getUserCartProductQuantity() {
		// TODO Auto-generated method stub
		Map<String, Integer> userCartProductQuantity = new HashMap<>();
		List<UserDetail> allUser = userDetailDAO.allUserDetail();
		allUser.forEach(user -> {
			userCartProductQuantity.put(user.getUserName(), user.getCart().getProducts().size());
		});
		return userCartProductQuantity;

	}

	@Override
	public UserDetail removeProductFromUserCart(long userId, long productId) {
		// TODO Auto-generated method stub
		List<UserDetail> allUser = userDetailDAO.getUserById(userId);

		UserDetail user = allUser.get(0);

		List<Product> newProductList =

				user.getCart().getProducts().stream()
				.filter(product -> product.getProductId() != productId)
				.collect(Collectors.toList());

		user.getCart().setProducts(newProductList);
		return userDetailDAO.save(user);

	}

	@Override
	public List<UserEmailAndCartDTO> getUserCartDetailWithExtraAddedProduct(long productId) {
		// TODO Auto-generated method stub
		List<UserEmailAndCartDTO> userEmailCarts = new ArrayList<>();
		List<UserDetail> allUser = userDetailDAO.allUserDetail();
		List<Product> allProduct = productDAO.getProductById(productId);
		for(UserDetail u : allUser) {
			UserEmailAndCartDTO dto = new UserEmailAndCartDTO();
			u.getCart().getProducts().add(allProduct.get(0));
			userDetailDAO.save(u);
			dto.setUserName(u.getUserName());
			dto.setCart(u.getCart());
			userEmailCarts.add(dto);
		}
		return userEmailCarts;
	}

	@Override
	public List<UserNameAndProductDTO> getUserNameWithProductNameAndPrice() {
		// TODO Auto-generated method stub
		List<UserNameAndProductDTO> userNameAndProductList = new ArrayList<>();
		List<UserDetail> allUser = userDetailDAO.allUserDetail();
		for(UserDetail u : allUser) {
			UserNameAndProductDTO userNameAndProductdto = new UserNameAndProductDTO();
			userNameAndProductdto.setEmail(u.getUserName());
			List<ProductWithoutQuantityDTO> pwqList = new ArrayList<>();
			for(Product p : u.getCart().getProducts()) {
			ProductWithoutQuantityDTO pwq = new ProductWithoutQuantityDTO();
			pwq.setProdName(p.getProdName());
			pwq.setPrice(p.getPrice());
			pwqList.add(pwq);
			}
			userNameAndProductdto.setProductWithoutQuantity(pwqList);
			
			userNameAndProductList.add(userNameAndProductdto);
			
		}
		return userNameAndProductList;
	}

	@Override
	public List<ProductWithoutQuantityDTO> getProductWithinRange(float startRange, float endRange) {
		// TODO Auto-generated method stub
		List<ProductWithoutQuantityDTO> allProducts = new ArrayList<>();
		List<Product> allProduct = productDAO.getallProduct();
		List<Product> allProductWithinRange = 
				allProduct.stream().filter(product -> product.getPrice() >= startRange && product.getPrice() <= endRange && product.getProductQuantity()>0)
				.collect(Collectors.toList());
		
		for(Product p : allProductWithinRange) {
			ProductWithoutQuantityDTO product = new ProductWithoutQuantityDTO();
			product.setProdName(p.getProdName());
			product.setPrice(p.getPrice());
			allProducts.add(product);
		}
		return allProducts;
	}

	@Override
	public List<PriceWithDiscountDTO> getProductWithDiscount(float discount) {
		// TODO Auto-generated method stub
		
		/*
		 * List<Product> allProduct = productDAO.getallProduct();
		 * 
		 * List<Product> allProductAfterDiscount = allProduct.stream(). map((product) ->
		 * product.setPrice(discountCalculation(discount,product.getPrice()))).collect
		 * 
		 * 
		 */
		
		
		
		
		
		
		
		
		
		
		
		
		
		//call ke baad start karenge
	
		/*
		 * List<PriceWithDiscountDTO> allProductwithDiscount = new ArrayList<>();
		 * List<Product> allProduct = productDAO.getallProduct(); for(Product p :
		 * allProduct) { PriceWithDiscountDTO priceWithDiscount = new
		 * PriceWithDiscountDTO(); float oldPrice = p.getPrice(); float caldiscount =
		 * discountCalculation(discount, oldPrice); float newPrice = oldPrice -
		 * caldiscount; priceWithDiscount.setProdName(p.getProdName());
		 * priceWithDiscount.setProductQuantity(p.getProductQuantity());
		 * priceWithDiscount.setNewPrice(newPrice);
		 * priceWithDiscount.setOldPrice(p.getPrice());
		 * allProductwithDiscount.add(priceWithDiscount); }
		 * 
		 * 
		 * //return tak comment kar de
		 * 
		 * 
		 * return allProductwithDiscount;
		 */
		
		return null;
	}
	
	private float discountCalculation(float discountPercent, float presentPrice) {
		return (discountPercent/100)* presentPrice;
	}

	@Override
	public Object forgetPassword(String userEmail) {
		// TODO Auto-generated method stub
		System.out.println(userEmail);
		int count = userDetailDAO.userCount(userEmail);
		if(count != 0) {
			OTP = sendingEmailUtil.sendMail(userEmail);
			currentUserEMail = userEmail;
			return "OTP Sent Sucessfully";
		}
		return "Email not present in the DB.";
	}

	@Override
	public Object checkOTP(String OTP) {
		// TODO Auto-generated method stub
		if(this.OTP.equals(OTP)) {
			this.OTP = null;
			return "Your password is "+userDetailDAO.getPasswordByUsername(currentUserEMail).get(0);
		}
		return "Wrong OTP.";
	}

	@Override
	public UserDetail updateUser(String userEmail) {
		// TODO Auto-generated method stub
		List<UserDetail> user = userDetailDAO.getUserById(1);
		
		user.get(0).setUserName("new@gmail.com");
		userDetailDAO.save(user.get(0));
		
		return null;
	}

	@Override
	public String test() {
		// TODO Auto-generated method stub
		return "in userdetail service";
	}

	@Override
	public UserDetail1DTO testObjectMapper() {
	
		UserDetail user = userDetailDAO.getUserById(1).get(0);
		
		UserDetail1DTO userDTO = mapper.map(user, UserDetail1DTO.class);
		
		return userDTO;
	}
	

}
