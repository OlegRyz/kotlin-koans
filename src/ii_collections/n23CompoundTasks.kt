package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> =
        customers.filter{it.orderedProducts.contains(product)}.toSet()

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    return orders.filter { it.isDelivered }.flatMap {it.products  }.maxBy { it.price }
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return customers.fold(0)
    {
        counter, customer ->
        customer.orders.fold(counter) {
            orderCounter, (products) ->
            products.count { it == product } + orderCounter
        }
    }
}
