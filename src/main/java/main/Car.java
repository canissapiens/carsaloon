package main;

import additives.*;

public class Car {
    private Model model;
    private Body body;
    private Color color;
    private Engine engine;
    private Upholstery upholstery;
    private int price;

    private Car(CarBuilder carBuilder) {
        model = carBuilder.getModel();
        body = carBuilder.getBody();
        color = carBuilder.getColor();
        engine = carBuilder.getEngine();
        upholstery = carBuilder.getUpholstery();
        price = carBuilder.getPrice();
    }

    @Override
    public String toString() {
        return "Samochód: {" +
                "marka=" + model +
                ", karoseria=" + body +
                ", kolor=" + color +
                ", silnik=" + engine +
                ", tapicerka=" + upholstery +
                ", cena=" + price +
                '}';
    }

    public static class CarBuilder {
        private Model model;
        private Body body;
        private Color color;
        private Engine engine;
        private Upholstery upholstery;

        public CarBuilder() {
        }

        public void setModel(Model model) {
            this.model = model;
        }

        public void setBody(Body body) {
            this.body = body;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public void setEngine(Engine engine) {
            this.engine = engine;
        }

        public void setUpholstery(Upholstery upholstery) {
            this.upholstery = upholstery;
        }

        public Model getModel() {
            return model;
        }

        public Body getBody() {
            return body;
        }

        public Color getColor() {
            return color;
        }

        public Engine getEngine() {
            return engine;
        }

        public Upholstery getUpholstery() {
            return upholstery;
        }

        public int getPrice() {

            int price = 0;
            if (model != null) {
                price += model.getPrice();
            }
            if (body != null) {
                price += body.getPrice();
            }
            if (color != null) {
                price += color.getPrice();
            }
            if (engine != null) {
                price += engine.getPrice();
            }
            if (upholstery != null) {
                price += upholstery.getPrice();
            }

            return price;
        }

        public int getPriceWithoutModel() {

            int price = getPrice();

            if (model != null) {
                price -= model.getPrice();
            }

            return price;
        }

        public int getPriceWithoutBody() {
            int price = getPrice();
            if (body != null) {
                price -= body.getPrice();
            }
            return price;
        }

        public int getPriceWithoutColor() {
            int price = getPrice();
            if (color != null) {
                price -= color.getPrice();
            }
            return price;
        }

        public int getPriceWithoutEngine() {
            int price = getPrice();
            if (engine != null) {
                price -= engine.getPrice();
            }
            return price;
        }

        public int getPriceWithoutUpholstery() {
            int price = getPrice();
            if (upholstery != null) {
                price -= upholstery.getPrice();
            }
            return price;
        }

        public Car buildCar() {
            int tmp = 0;
            return new Car(this);
        }

        public boolean isCarComplete() {
            return (model != null && body != null && color != null && engine != null && upholstery != null);
        }

        @Override
        public String toString() {
            return "Twój obecny wybór{" +
                    "model=" + model +
                    ", body=" + body +
                    ", color=" + color +
                    ", engine=" + engine +
                    ", upholstery=" + upholstery +
                    ", price=" + getPrice() +
                    '}';
        }

    } // CarBuilder
}
