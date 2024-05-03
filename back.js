const express = require('express');
const bodyParser = require('body-parser');
const mongoose = require('mongoose');
const cors = require('cors');
const app = express();

// MongoDB connection setup
mongoose.connect('mongodb://localhost:27017/shoppingCart', {
    useNewUrlParser: true,
    useUnifiedTopology: true,
})
.then(() => console.log('Connected to MongoDB'))
.catch(err => console.error('Error connecting to MongoDB:', err));

// Define CartItem schema
const cartItemSchema = new mongoose.Schema({
    productId: {
        type: Number,
        required: true,
    },
    productName: {
        type: String,
        required: true,
    },
    price: {
        type: Number,
        required: true,
    },
    quantity: {
        type: Number,
        required: true,
    },
    description: String,
    category: String,
    image: String,
});

const CartItem = mongoose.model('CartItem', cartItemSchema);

// Middleware
app.use(bodyParser.json());
app.use(cors());

// Route to handle adding items to the cart
app.post('/addToCart', (req, res) => {
    const { productId, productName, price, quantity, description, category, image } = req.body;

    const newItem = new CartItem({
        productId,
        productName,
        price,
        quantity,
        description,
        category,
        image,
    });

    newItem.save()
        .then(() => {
            res.status(201).json({ message: 'Item added to cart successfully' });
        })
        .catch(err => {
            console.error('Error adding item to cart:', err);
            res.status(500).json({ error: 'Internal server error' });
        });
});

// Route to get all cart items
app.get('/getCartItems', (req, res) => {
    CartItem.find()
        .then(cartItems => {
            res.json(cartItems);
        })
        .catch(err => {
            console.error('Error fetching cart items:', err);
            res.status(500).json({ error: 'Internal server error' });
        });
});

// Start the server
const PORT = 3000;
app.listen(PORT, () => {
    console.log(`Server running on port ${PORT}`);
});
