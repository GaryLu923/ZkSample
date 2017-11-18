package org.gary.ZkSample.controller;

import java.util.Date;

import org.gary.ZkSample.entity.User;
import org.gary.ZkSample.services.MyService;
import org.gary.ZkSample.services.UserService;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;

import com.google.common.base.Optional;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class DashBoardController extends SelectorComposer<Component> {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Wire private Textbox nameBox;

	@Wire private Textbox emailBox;

	@Wire private Textbox passwordBox;

	@Wire private Radiogroup genderRadio;

	@Wire private Datebox birthdayBox;

	@WireVariable UserService userService;

	@WireVariable MyService myService;

	@Listen("onClick=#submitButton")
	public void saveUser() {
		Optional<String> optionalNameBoxValue = Optional.of(nameBox.getValue());
		Optional<String> optionalEmailBoxValue = Optional.of(emailBox.getValue());
		Optional<String> optionalPasswordBoxValue = Optional.of(passwordBox.getValue());
		Optional<String> optionalGenderRadioValue = Optional.of((String) genderRadio.getSelectedItem().getValue());
		Optional<Date> optionalBirthdayBoxValue = Optional.of(birthdayBox.getValue());
		boolean isFemale = "female".equals(optionalGenderRadioValue.get()) ? true : false;
		if (optionalBirthdayBoxValue.isPresent() && optionalEmailBoxValue.isPresent()
				&& optionalGenderRadioValue.isPresent() && optionalNameBoxValue.isPresent()
				&& optionalPasswordBoxValue.isPresent()) {
			User user = userService.addUser(new User(optionalNameBoxValue.get(), optionalEmailBoxValue.get(),
					optionalPasswordBoxValue.get(), isFemale, optionalBirthdayBoxValue.get()));
		}
	}

}
