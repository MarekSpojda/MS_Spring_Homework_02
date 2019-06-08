package pl.coderslab.model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class CartController {
    private Cart cart;
    private List<Product> myProducts;

    public CartController(Cart cart) {
        this.cart = cart;
        myProducts = ProduktDao.getList();
    }

    @GetMapping(path = "/addtocart/{id}/{quantity}", produces = "text/html; charset=UTF-8")
    public RedirectView addtocart(@PathVariable Long id, @PathVariable int quantity) {
        for (Product product : myProducts) {
            if (product.getId().equals(id)) {
                boolean alreadyInCart = false;
                for (CartItem cartItem : this.cart.getCartItems()) {
                    if (cartItem.getProduct().getId().equals(id)) {
                        cartItem.setQuantity(cartItem.getQuantity() + quantity);
                        alreadyInCart = true;
                        break;
                    }
                }
                if (!alreadyInCart) {
                    CartItem cartItem = new CartItem();
                    cartItem.setQuantity(quantity);
                    cartItem.setProduct(product);
                    cart.addToCart(cartItem);
                    break;
                }
            }
        }

        return new RedirectView("/cart");
    }

    @RequestMapping(path = "/cart", produces = "text/html; charset=UTF-8")
    public String cart(Model model) {
        StringBuilder stringBuilder = new StringBuilder();
        for (CartItem cartItem : cart.getCartItems()) {
            stringBuilder.append(cartItem.getProduct().getName()).
                    append(" <a href=\"/removeproduct?product=").append(cartItem.getProduct().getName()).append("\">Usuń produkt</a>").
                    append(" <a href=\"/raiseby1?product=").append(cartItem.getProduct().getName()).append("\">Zwiększ o 1</a>").
                    append(" <a href=\"/decreaseby1?product=").append(cartItem.getProduct().getName()).append("\">Zmniejsz o 1</a>").
                    append("<br>");
        }

        stringBuilder.append("W koszyku jest ").append(cart.getCartItems().size()).append(" pozycji.<br>");

        int amountOfProducts = 0;
        for (CartItem cartItem : this.cart.getCartItems()) {
            amountOfProducts += cartItem.getQuantity();
        }
        stringBuilder.append("W koszyku jest ").append(amountOfProducts).append(" produktów.<br>");

        double cartValue = 0D;
        for (CartItem cartItem : cart.getCartItems()) {
            cartValue += cartItem.getProduct().getPrice() * ((double) cartItem.getQuantity());
        }
        stringBuilder.append("Wartość koszyka to ").append(cartValue).append("zł.<br>");

        model.addAttribute("cart", stringBuilder.toString());

        return "WEB-INF/views/cart.jsp";
    }

    @RequestMapping(path = "/addproduct", produces = "text/html; charset=UTF-8")
    public String addproduct() {
        return "WEB-INF/views/addproductform.jsp";
    }

    @RequestMapping(path = "/removeproduct", produces = "text/html; charset=UTF-8")
    public String removeproduct(@RequestParam String product) {
        this.cart.removeCartItem(product);
        return "/cart";
    }

    @RequestMapping(path = "/raiseby1", produces = "text/html; charset=UTF-8")
    public String raiseby1(@RequestParam String product) {
        this.cart.getCartItem(product).setQuantity(this.cart.getCartItem(product).getQuantity() + 1);
        return "/cart";
    }

    @RequestMapping(path = "/decreaseby1", produces = "text/html; charset=UTF-8")
    public String decreaseby1(@RequestParam String product) {
        this.cart.getCartItem(product).setQuantity(this.cart.getCartItem(product).getQuantity() - 1);
        return "/cart";
    }

    @RequestMapping(path = "/processproduct", produces = "text/html; charset=UTF-8")
    public String processproduct(@RequestParam Long choosenproduct, @RequestParam int quantity, Model model) {
        model.addAttribute("id", choosenproduct);
        model.addAttribute("quantity", quantity);
        return "/addtocart/" + choosenproduct + "/" + quantity;
    }
}
