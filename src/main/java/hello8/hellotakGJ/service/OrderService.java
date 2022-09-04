package hello8.hellotakGJ.service;

import hello8.hellotakGJ.domain.*;
import hello8.hellotakGJ.domain.item.Item;
import hello8.hellotakGJ.repository.ItemRepository;
import hello8.hellotakGJ.repository.MemberRepository;
import hello8.hellotakGJ.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static hello8.hellotakGJ.domain.Order.createOrder;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    //주문
    @Transactional //데이터를 변경하는 것이기때문
    public Long order(Long memberId, Long itemId, int count) {

        //엔티티 조회
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        //배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());
        delivery.setStatus(DeliveryStatus.READY);
        //주문상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
        //주문 생성
        Order order = createOrder(member, delivery, orderItem);
        //주문 저장
        orderRepository.save(order);
        return order.getId();
    }
    /** 주문 취소 */
    @Transactional
    public void cancelOrder(Long orderId) {
    //주문 엔티티 조회
        Order order = (Order) orderRepository.findOne(orderId);
    //주문 취소
        order.cancel();
    }
    /** 주문 검색 */

      public List<Order> findOrders(OrderSearch orderSearch) {
          return orderRepository.findAll(orderSearch);
    }
}
