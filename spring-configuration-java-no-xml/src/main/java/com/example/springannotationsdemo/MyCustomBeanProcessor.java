package com.example.springannotationsdemo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyCustomBeanProcessor implements DisposableBean, BeanPostProcessor, BeanFactoryAware {
	
	private BeanFactory beanFactory;
	private List<Object> prototypeBeans = new LinkedList<Object>();

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		this.beanFactory = arg0;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		// after start up, keep track of the prototype scoped beans. 
		// we will need to know who they are for later destruction
		
		if (beanFactory.isPrototype(beanName)) {
			synchronized (prototypeBeans) {
				prototypeBeans.add(bean);
			}
		}

		return bean;
	}

	@Override
	public void destroy() throws Exception {
		synchronized (prototypeBeans) {
			for (Object bean : prototypeBeans) {
				if (bean instanceof DisposableBean) {
					DisposableBean disposable = (DisposableBean) bean;
					
					try {
						disposable.destroy();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
			prototypeBeans.clear();
		}
	}

}
