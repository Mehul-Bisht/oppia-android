package org.oppia.android.app.onboarding

import android.content.Context
import android.content.Intent
import android.os.Bundle
import org.oppia.android.app.activity.InjectableAppCompatActivity
import org.oppia.android.app.profile.ProfileChooserActivity
import javax.inject.Inject

/** Activity that contains the onboarding flow for learners. */
class OnboardingActivity : InjectableAppCompatActivity(), RouteToProfileListListener {
  @Inject
  lateinit var onboardingActivityPresenter: OnboardingActivityPresenter

  companion object {
    fun createOnboardingActivity(context: Context): Intent {
      val intent = Intent(context, OnboardingActivity::class.java)
      intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
      return intent
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    activityComponent.inject(this)
    onboardingActivityPresenter.handleOnCreate()
  }

  override fun routeToProfileList() {
    startActivity(ProfileChooserActivity.createProfileChooserActivity(this))
    finish()
  }
}
