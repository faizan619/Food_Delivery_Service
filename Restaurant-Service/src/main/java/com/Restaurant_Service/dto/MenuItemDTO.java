    package com.Restaurant_Service.dto;

    import jakarta.validation.constraints.NotBlank;
    import jakarta.validation.constraints.NotNull;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

    @Getter
    @Setter
    @NoArgsConstructor
    public class MenuItemDTO {
        
        @NotBlank(message="Item Cannot be Blank")
        private String name;

        @NotNull(message="Price Cannot Be Null")
        private double price;

        @NotNull(message="Restaurant Value is required")
        private int restaurantId;

        private Boolean availablity = true;

        public MenuItemDTO(String name, double price, Boolean availablity,int restaurantId){
            this.name = name;
            this.price = price;
            this.availablity = availablity;
            this.restaurantId = restaurantId;
        }
        public MenuItemDTO(String name, double price,int restaurantId){
            System.out.println("============[constructor]==================[ "+restaurantId+" ]");
            this.name = name;
            this.price = price;
            this.restaurantId = restaurantId;
        }
    }
