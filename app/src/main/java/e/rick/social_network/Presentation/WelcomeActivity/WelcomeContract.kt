package e.rick.advancedkotlin.Presentation.HomeActivity

interface WelcomeContract {

    interface View {

        fun goToHomeActivity()
    }

    interface Presenter {

        fun loginWithEmail(email: String, password: String)

        fun checkCurrentUser() : Boolean
    }
}