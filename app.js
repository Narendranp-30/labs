const express = require('express')
const mongoose = require('mongoose')
const app = express()
const port = 3000
const Expense=require('./models/product')
mongoose.connect("mongodb://0.0.0.0:27017/Ecom"),{
    useUnifiedTopology:true
};
app.use(express.json())

app.get('/', async (req, res) => {
    const expenses=await Expense.find();
  res.send(expenses)
})

app.get('/expense/:id', async (req,res) => {
  try {
      const id = req.params.id;
      const result = await Expense.findById(id);
      if(result)
          res.send(result);
      else
          res.send ("No such Expenses were found according to ur id");
  }
  catch(err){
      res.send(err);
  }
})

app.delete('/expense/:id', async (req,res) => {
  try {
      const id = req.params.id;
      const result = await Expense.findByIdAndDelete(id);
      if(result)
          res.send(result);
      else
          res.send ("No such Expenses were found according to ur id");
  }
  catch(err){
      res.send(err);
  }  
})

app.post('/expense', async (req,res) => {
  console.log(req.body)
  const newExpense = req.body;
  await Expense.create(newExpense);
  res.send("hi")
})

app.post('/expenses',async (req, res) => {
  const expenses=await Expense.find();
    res.send(expenses)
  })

app.put('/expense/:id', async(req, res) => {
    const id = req.params.id;
    const updateObject = req.body;
    const updatedObject = await Expense.findByIdAndUpdate(id, {$set: updateObject}, {
        new: true
    })
    res.send(updatedObject);
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})
